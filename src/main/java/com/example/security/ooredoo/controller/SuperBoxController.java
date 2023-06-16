package com.example.security.ooredoo.controller;

import com.example.security.ooredoo.entities.SuperBox;
import com.example.security.ooredoo.services.SuperBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Base64;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("SuperBox")
@CrossOrigin("*")
public class SuperBoxController {
    @Autowired
    SuperBoxService superBoxService;
    private SuperBox superBox;
    public SuperBoxController(SuperBoxService superBoxService) {
        this.superBoxService = superBoxService;
        this.superBox = new SuperBox(); // Créer une instance de SuperBox
    }

    @PostMapping("/ajouter")
    public SuperBox add(@RequestBody SuperBox userSuperBox) {
        superBox.setId(userSuperBox.getId());
        superBox.setChoix(userSuperBox.getChoix());
        superBox.setIccid(userSuperBox.getIccid());
        superBox.setMsisdn(userSuperBox.getMsisdn());
        superBox.setNumeroserie(userSuperBox.getNumeroserie());
        superBox.setZonerecherche(userSuperBox.getZonerecherche());
        return superBoxService.ajouter(superBox);
    }

    @PostMapping("/add")
    public ResponseEntity<SuperBox> add(@RequestBody Map<String, Object> requestData) {
        try {
            String signatureDataURL = (String) requestData.get("signature");
            String base64Image = signatureDataURL.replace("data:image/png;base64,", "");
            byte[] imageBytes = Base64.getDecoder().decode(base64Image);
            superBox.setSignatureImage(imageBytes);
            // Copiez d'autres propriétés de requestData vers superBox
            SuperBox addedSuperBox = superBoxService.ajouter(superBox);
            return ResponseEntity.ok().body(addedSuperBox);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    @GetMapping("/signature/{id}")
    public ResponseEntity<byte[]> getSignatureImage(@PathVariable Integer id) {
        try {
            SuperBox superBox = superBoxService.getById(id);
            byte[] signatureImage = superBox.getSignatureImage();

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_PNG);
            headers.setContentLength(signatureImage.length);

            return new ResponseEntity<>(signatureImage, headers, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/list")
    public List<SuperBox> finAllActivation(){

        return superBoxService.getAllList();
    }

    @PutMapping("update/{id}")
    public SuperBox update(@PathVariable Integer id, @RequestBody SuperBox superBox) {

    SuperBox exitingSuperBox = superBoxService.getList(id);
        exitingSuperBox.setChoix(superBox.getChoix());
        exitingSuperBox.setIccid(superBox.getIccid());
        exitingSuperBox.setMsisdn(superBox.getMsisdn());
        exitingSuperBox.setNumeroserie(superBox.getNumeroserie());
        exitingSuperBox.setZonerecherche(superBox.getZonerecherche());

        return superBoxService.addSuperBox(exitingSuperBox);


    }
    @DeleteMapping("delete/{id}")
    public void delete (@PathVariable Integer id ){

        superBoxService.delete(id);
    }
}
