package com.codegym.ben_xe.controler;

import com.codegym.ben_xe.model.BenXe;
import com.codegym.ben_xe.model.DiaDiem;
import com.codegym.ben_xe.model.LoaiXe;
import com.codegym.ben_xe.model.NhaXe;
import com.codegym.ben_xe.service.IBenXeService;
import com.codegym.ben_xe.service.IDiaDiemService;
import com.codegym.ben_xe.service.ILoaiXeService;
import com.codegym.ben_xe.service.INhaXeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping("/api/ben-xe")
public class BenXeRestControler {
    @Autowired
    private IBenXeService benXeService;
    @Autowired
    private ILoaiXeService loaiXeService;
    @Autowired
    private INhaXeService nhaXeService;
    @Autowired
    private IDiaDiemService diaDiemService;
    @GetMapping("")
    public ResponseEntity<List<BenXe>> getAll(){
        List<BenXe> benXeList = this.benXeService.getAll();
        return new ResponseEntity<>(benXeList, HttpStatus.OK);
    }
    @GetMapping("/loaiXe")
    public ResponseEntity<List<LoaiXe>> getAllLoaiXe(){
        List<LoaiXe> loaiXeList = this.loaiXeService.getAllLoaiXe();
        return new ResponseEntity<>(loaiXeList, HttpStatus.OK);
    }
    @GetMapping("/nhaXe")
    public ResponseEntity<List<NhaXe>> getAllNhaXe(){
        List<NhaXe> nhaXeList = this.nhaXeService.getAllNhaXe();
        return new ResponseEntity<>(nhaXeList, HttpStatus.OK);
    }
    @GetMapping("/diaDiem")
    public ResponseEntity<List<DiaDiem>> getAllDiaDiem(){
        List<DiaDiem> diaDiemList = this.diaDiemService.getAllDiaDiem();
        return new ResponseEntity<>(diaDiemList, HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<BenXe> create(@RequestBody BenXe benXe){
        if (this.benXeService.save(benXe)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<BenXe> findBenXeById(@PathVariable int id){
        if (this.benXeService.findBenXeById(id)!= null){
            return new ResponseEntity<>(this.benXeService.findBenXeById(id), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<BenXe> update(@PathVariable int id, @RequestBody BenXe benXe){
        if (this.benXeService.update(id, benXe)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<BenXe> remover(@PathVariable int id){
        if (this.benXeService.remove(id)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }
}
