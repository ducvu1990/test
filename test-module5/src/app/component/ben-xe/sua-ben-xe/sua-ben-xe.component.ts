import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {BenXeService} from '../../../service/ben-xe.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {DiaDiem} from '../../../model/dia-diem';
import {LoaiXe} from '../../../model/loai-xe';
import {NhaXe} from '../../../model/nha-xe';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-sua-ben-xe',
  templateUrl: './sua-ben-xe.component.html',
  styleUrls: ['./sua-ben-xe.component.css']
})
export class SuaBenXeComponent implements OnInit {
  rfBenXe: FormGroup = new FormGroup({
    id: new FormControl(),
    soXe: new FormControl(),
    loaiXe: new FormControl(),
    nhaXe: new FormControl(),
    diemDi: new FormControl(),
    diemDen: new FormControl(),
    soDienThoai: new FormControl(),
    email: new FormControl(),
    gioDi: new FormControl(),
    gioDen: new FormControl(),
  });
  diaDiems: DiaDiem[];
  nhaXes: NhaXe[];
  loaiXes: LoaiXe[];
  id: number;

  constructor(private benXeService: BenXeService,
              private activatedRoute: ActivatedRoute,
              private router: Router) {
  }

  ngOnInit(): void {
    this.getBenXe();
  }

  getBenXe() {
    this.benXeService.getAllDiaDiem().subscribe(diaDiemes => {
      this.diaDiems = diaDiemes;
    });
    this.benXeService.getAllNhaXe().subscribe(nhaXees => {
      this.nhaXes = nhaXees;
    });
    this.benXeService.getAllLoaiXe().subscribe(laoiXees => {
      this.loaiXes = laoiXees;
    });
    this.activatedRoute.paramMap.subscribe((paraMap: ParamMap) => {
      this.id = parseInt(paraMap.get('id'), 10);
      this.benXeService.findById(this.id).subscribe(benXees => {
        this.rfBenXe = new FormGroup({
          id: new FormControl(benXees.id, Validators.required),
          soXe: new FormControl(benXees.soXe, Validators.required),
          loaiXe: new FormControl(this.loaiXes?.filter(loaiXees => loaiXees.id === benXees.loaiXe.id)[0]),
          nhaXe: new FormControl(this.nhaXes?.filter(nhaXees => nhaXees.id === benXees.nhaXe.id)[0]),
          diemDi: new FormControl(this.diaDiems?.filter(diadiemes => diadiemes.id === benXees.diemDi.id)[0]),
          diemDen: new FormControl(this.diaDiems?.filter(diadiemes => diadiemes.id === benXees.diemDen.id)[0]),
          soDienThoai: new FormControl(benXees.soDienThoai),
          email: new FormControl(benXees.email),
          gioDi: new FormControl(benXees.gioDi),
          gioDen: new FormControl(benXees.gioDen),
        });
      });
    });
  }

  updateBenXe() {
    const benXe = this.rfBenXe.value;
    this.benXeService.update(this.id, benXe).subscribe(() => {
      this.router.navigateByUrl('/benXe');
      Swal.fire(
        'Sữa thành công!',
        'Your file has been deleted.',
        'success'
      );
    }, error => {
      Swal.fire(
        'Sữa thất bại!',
        'Your file has been deleted.',
        'error'
      );
    });
  }
}
