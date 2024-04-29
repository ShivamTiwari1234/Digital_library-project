package com.example.Minorproject.Digital.library.Controller;

import com.example.Minorproject.Digital.library.Models.MyUser;
import com.example.Minorproject.Digital.library.service.TransactionServiceInterf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TranctionController {
    @Autowired
    TransactionServiceInterf tranctionServiceInterf;


    @PostMapping("/tranction/{tranctionType}")
    public ResponseEntity tranct(@RequestParam("studentId") int studentId,
                                 @RequestParam("bookId") int bookID, @PathVariable("tranctionType") String tranctionType) throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        MyUser myUser = (MyUser) authentication.getPrincipal();

        if(myUser.getStudent() == null) {
            throw new Exception("User is not a student.");
        }

        return new ResponseEntity(tranctionServiceInterf.transact(myUser.getStudent().getId(), bookID, tranctionType), HttpStatus.OK);
    }

}
