package com.focustechnology.sellmycar.auction.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auction")
public class AuctionController {

    @GetMapping("/active-auctions")
    public ResponseEntity<String> getActiveAuctions() {
        return ResponseEntity.ok("List of active auctions. Secured endpoint!");
    }
}
