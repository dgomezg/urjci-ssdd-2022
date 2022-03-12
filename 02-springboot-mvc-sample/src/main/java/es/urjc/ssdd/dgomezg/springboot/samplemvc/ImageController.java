package es.urjc.ssdd.dgomezg.springboot.samplemvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.UrlResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.springframework.http.HttpHeaders.CONTENT_TYPE;

@Controller
public class ImageController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ImageController.class);

    public static final Path IMAGES_FOLDER = Path.of("uploadedImages");

    @PostMapping("/upload-image")
    public String uploadImage(Model model, @RequestParam String imageName, @RequestParam MultipartFile imageFile) throws IOException {

        LOGGER.debug("received image file {} with size {}", imageName, imageFile.getSize());

        Files.createDirectories(IMAGES_FOLDER);
        Path imagePath = IMAGES_FOLDER.resolve(imageName);

        LOGGER.trace("Storing image {} at {} ", imageName, imagePath.toString());
        imageFile.transferTo(imagePath);

        LOGGER.trace("Image {} stored at {} ", imageName, imagePath.toString());

        model.addAttribute("imageName", imageName);

        return "uploaded-image";
    }

    @GetMapping("/show-image/{imageName}")
    public String viewImage(Model model, @PathVariable String imageName) {
        Path imagePath = IMAGES_FOLDER.resolve(imageName);

        model.addAttribute("imageName", imageName);
        model.addAttribute("imagePath", imagePath.toString());

        return "view-image";
    }

    @GetMapping("/download-image/{imageName}")
    public ResponseEntity<Object> downloadImage(Model model, @PathVariable String imageName) throws MalformedURLException {
        Path imagePath = IMAGES_FOLDER.resolve(imageName);

        UrlResource image = new UrlResource(imagePath.toUri());

        return ResponseEntity.ok()
                .header(CONTENT_TYPE, "image/jpeg")
                .body(image);

    }


}
