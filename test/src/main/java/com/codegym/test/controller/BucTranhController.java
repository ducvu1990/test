package com.codegym.test.controller;

import com.codegym.test.model.BucTranh;
import com.codegym.test.service.IBucTranhService;
import com.codegym.test.service.ITheLoaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/buc-tranh")
public class BucTranhController {
    @Autowired
    private IBucTranhService bucTranhService;
    @Autowired
    private ITheLoaiService theLoaiService;

    @GetMapping("listAndSearch")
    public String findListAndSearchBucTranh(@RequestParam(required = false, defaultValue = "") String nameSearch,
                                            @RequestParam(required = false, defaultValue = "0") int page,
                                            Model model) {
        Pageable pageable = PageRequest.of(page, 10);
        Page<BucTranh> bucTranhPage = bucTranhService.findAllAndSearch(nameSearch, pageable);
        model.addAttribute("bucTranhPage",bucTranhPage);
        return "/bucTranh/bucTranh";
    }
    @PostMapping("delete")
    public String delete(@RequestParam int deleteId, RedirectAttributes attributes){
        bucTranhService.remove(deleteId);
        attributes.addFlashAttribute("message","xóa thành công");
        return "redirect:/buc-tranh/listAndSearch";
    }
    @GetMapping("create")
    public String create(Model model){
        model.addAttribute("bucTranh", new BucTranh());
        model.addAttribute("theLoais", theLoaiService.showAll());
        return "/bucTranh/them";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute BucTranh bucTranh,RedirectAttributes attributes){
        bucTranhService.save(bucTranh);
        attributes.addFlashAttribute("message", "thêm mới thanh công");
        return "redirect:/buc-tranh/listAndSearch";
    }
}
