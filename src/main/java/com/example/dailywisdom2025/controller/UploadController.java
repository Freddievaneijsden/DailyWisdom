package com.example.dailywisdom2025.controller;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UploadController {

    public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/uploads";

    @GetMapping("/show-images")
    public String showUploadedImages(Model model) {
        File folder = new File(UPLOAD_DIRECTORY);
        File[] files = folder.listFiles();

        List<String> fileNames = new ArrayList<>();
        if (files != null) {
            for (File file : files) {
                fileNames.add(file.getName());
            }
        }

        model.addAttribute("images", fileNames);
        return "imageupload/show-images";
    }

    @GetMapping("/uploadimage")
    public String displayUploadForm() {
        return "imageupload/index";
    }


    @GetMapping("/upload")
    public String redirectToUploadForm() {
        return "redirect:/uploadimage";
    }

    @PostMapping("/upload") public String uploadImage(Model model, @RequestParam("image") MultipartFile file) throws IOException {

        Path uploadDir = Paths.get(UPLOAD_DIRECTORY);
        if (!Files.exists(uploadDir)) {
            Files.createDirectories(uploadDir);
        }

        if (file.isEmpty()) {
            model.addAttribute("msg", "Please select an image to upload.");
            return "imageupload/index";
        }

        Path fileNameAndPath = uploadDir.resolve(file.getOriginalFilename());
        Files.write(fileNameAndPath, file.getBytes());

        model.addAttribute("msg", "Uploaded image: " + file.getOriginalFilename());
        return "imageupload/index";
    }

    @GetMapping("/user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returns current user",
                    content = { @Content (mediaType = ("application/json"))}
            )})
    public ResponseEntity<String> user(){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return ResponseEntity.ok("User: " + username);
    }
}
