package com.example.security.ooredoo.controller;

import com.example.security.ooredoo.entities.FastBox;
import com.example.security.ooredoo.entities.SuperBox;
import com.example.security.ooredoo.repositories.FastBoxRepo;
import com.example.security.ooredoo.services.FastBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.*;

@RestController
@RequestMapping("FastBox")
@CrossOrigin("*")
public class FastBoxController {
    @Autowired
    private FastBoxService fastBoxService;
    @Autowired
    private   FastBoxRepo fastBoxRepo;
    private FastBox fastBox;
    @Autowired
    public FastBoxController(FastBoxService fastBoxService) {
        this.fastBoxService = fastBoxService;
        this.fastBox = new FastBox(); // Initialisation de l'instance partagée
    }
    @GetMapping("/verify/{numeroTT}")
   public boolean verifyClient(@PathVariable String numeroTT) {
        return fastBoxRepo.existsByNumeroTT(numeroTT);
    }
    @PostMapping("/ajouter")
    public FastBox add(@RequestBody FastBox userFastBox) {
        fastBox.setId(userFastBox.getId());
        fastBox.setClientPossedeNumero(userFastBox.isClientPossedeNumero());
        fastBox.setPrix(userFastBox.getPrix());
        fastBox.setAbonnement(userFastBox.getAbonnement());
        fastBox.setCategorie(userFastBox.getCategorie());
        fastBox.setNumeroTT(userFastBox.getNumeroTT());
        fastBox.setDebit(userFastBox.getDebit());
        fastBox.setNumeroserie(userFastBox.getNumeroserie());
        fastBox.setMsisdn(userFastBox.getMsisdn());
        fastBox.setSignatureImage(userFastBox.getSignatureImage());
        return fastBoxService.ajouter(fastBox);
    }
    @PostMapping("/add")
    public ResponseEntity<FastBox> add(@RequestBody Map<String, Object> requestData) {
        try {
            String signatureDataURL = (String) requestData.get("signature");
            String base64Image = signatureDataURL.replace("data:image/png;base64,", "");
            byte[] imageBytes = Base64.getDecoder().decode(base64Image);
            FastBox fastBox = new FastBox();
            fastBox.setSignatureImage(imageBytes);
            // Copiez d'autres propriétés de requestData vers superBox
            FastBox addedFastBox = fastBoxService.ajouter(fastBox);
            return ResponseEntity.ok().body(addedFastBox);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/signature/{id}")
    public ResponseEntity<byte[]> getSignatureImage(@PathVariable Integer id) {
        try {
            FastBox fastBox = fastBoxService.getById(id);
            byte[] signatureImage = fastBox.getSignatureImage();

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_PNG);
            headers.setContentLength(signatureImage.length);

            return new ResponseEntity<>(signatureImage, headers, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }




    @GetMapping("/list")
    public List<FastBox> finAllFastBox(){

        return fastBoxService.getAllList();
    }
    @PutMapping("update/{id}")
    public FastBox update(@PathVariable Integer id, @RequestBody FastBox fastBox) {

        FastBox exitingFastBox = fastBoxService.getList(id);
        exitingFastBox.setDebit(fastBox.getDebit());
        exitingFastBox.setPrix(fastBox.getPrix());
        exitingFastBox.setNumeroserie(fastBox.getNumeroserie());
        exitingFastBox.setMsisdn(fastBox.getMsisdn());
        exitingFastBox.setNumeroTT(fastBox.getNumeroTT());
        exitingFastBox.setCategorie(fastBox.getCategorie());
        exitingFastBox.setAbonnement(fastBox.getAbonnement());
        exitingFastBox.setClientPossedeNumero(fastBox.isClientPossedeNumero());
        exitingFastBox.setSignatureImage(fastBox.getSignatureImage());

        return fastBoxService.add(exitingFastBox);


    }
    @DeleteMapping("delete/{id}")
    public void delete (@PathVariable Integer id ){
        fastBoxService.delete(id);
    }
}
