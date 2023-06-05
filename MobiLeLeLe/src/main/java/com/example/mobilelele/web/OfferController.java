package com.example.mobilelele.web;

import com.example.mobilelele.models.dto.offer.AddOfferDTO;
import com.example.mobilelele.services.BrandService;
import com.example.mobilelele.services.OfferService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class OfferController {
    private final OfferService offerService;

    private final BrandService brandService;

    @Autowired
    public OfferController(OfferService offerService, BrandService brandService) {
        this.offerService = offerService;
        this.brandService = brandService;
    }

    @GetMapping("/offers/all")
    public String allOffers() {
        return "offers";
    }

    @GetMapping("/offers/add")
    public String addOffers(Model model) {
        if (!model.containsAttribute("addOfferModel")) {
            model.addAttribute("addOfferModel", new AddOfferDTO());
        }
        model.addAttribute("brands", brandService.getAllBrands());

        return "offer-add";
    }

    @PostMapping("/offers/add")
    public String addOffers(@Valid AddOfferDTO addOfferDTO, BindingResult bindingResult,
                            RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("addOfferModel", addOfferDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addOfferModel",
                    bindingResult);
            return "redirect:/offers/add";
        }

        offerService.addOffer(addOfferDTO);

        return "redirect:/offers/all";
    }
}
