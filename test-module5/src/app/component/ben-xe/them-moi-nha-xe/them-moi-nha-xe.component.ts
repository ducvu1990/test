import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormControl, FormGroup, ValidatorFn, Validators} from '@angular/forms';
import {LoaiXe} from '../../../model/loai-xe';
import {NhaXe} from '../../../model/nha-xe';
import {DiaDiem} from '../../../model/dia-diem';
import {BenXeService} from '../../../service/ben-xe.service';
import {Router} from '@angular/router';
import Swal from 'sweetalert2';
import {Time} from '@angular/common';

@Component({
  selector: 'app-them-moi-nha-xe',
  templateUrl: './them-moi-nha-xe.component.html',
  styleUrls: ['./them-moi-nha-xe.component.css']
})
export class ThemMoiNhaXeComponent implements OnInit {
  rfBenXe: FormGroup;
  loaiXes: LoaiXe[];
  nhaXes: NhaXe[];
  diaDiems: DiaDiem[];

  constructor(private benXeservice: BenXeService,
              private router: Router) {
  }

  ngOnInit(): void {
    this.benXeservice.getAllNhaXe().subscribe(nhaXees => {
      this.nhaXes = nhaXees;
    });
    this.benXeservice.getAllLoaiXe().subscribe(loaiXees => {
      this.loaiXes = loaiXees;
    });
    this.benXeservice.getAllDiaDiem().subscribe(diaDiemes => {
      this.diaDiems = diaDiemes;
    });
    this.rfBenXe = new FormGroup({
      soXe: new FormControl('', Validators.required),
      loaiXe: new FormControl('', Validators.required),
      nhaXe: new FormControl('', Validators.required),
      diemDi: new FormControl('', Validators.required),
      diemDen: new FormControl('', Validators.required),
      soDienThoai: new FormControl('', [Validators.required, Validators.pattern('^(090|093|097)\\d{7}$')]),
      email: new FormControl('', [Validators.required, Validators.email]),
      gioDi: new FormControl('', [Validators.required, this.validateTimeRange]),
      gioDen: new FormControl('', [Validators.required, this.validateTimeRange]),
    });
  }

  saveBenXe() {
    const benXe = this.rfBenXe.value;
    this.benXeservice.create(benXe).subscribe(() => {
      this.router.navigateByUrl('/benXe');
      Swal.fire(
        'Thêm Mới thành công!',
        'Your file has been deleted.',
        'success'
      );
    }, error => {
      Swal.fire(
        'Thêm Mới thất bại!, số xe đã tồn tại',
        'Your file has been deleted.',
        'error'
      );
    });
  }

  validateTimeRange(control: AbstractControl) {
    const [hours, minutes] = control.value.split(':').map(Number);
    const hour: Time = {hours, minutes};
    if (isNaN(hour.hours) || isNaN(hour.minutes)) {
      return {timerange: true};
    }
    const minHour: Time = {hours: 5, minutes: 0};
    const maxHour: Time = {hours: 23, minutes: 0};
    if (hour.hours < minHour.hours || (hour.hours === maxHour.hours && hour.minutes > maxHour.minutes) || hour.hours > maxHour.hours) {
      return {timerange: true};
    }
    return null;
  }
}
