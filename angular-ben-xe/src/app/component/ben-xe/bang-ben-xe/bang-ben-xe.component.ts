import {Component, OnInit} from '@angular/core';
import {BenXeService} from '../../../service/ben-xe.service';
import {BenXe} from '../../../model/ben-xe';
import Swal from 'sweetalert2';
import {FormGroup} from '@angular/forms';

@Component({
  selector: 'app-bang-ben-xe',
  templateUrl: './bang-ben-xe.component.html',
  styleUrls: ['./bang-ben-xe.component.css']
})
export class BangBenXeComponent implements OnInit {
  benXes: BenXe[];
  soXe = '';

  constructor(private benXeService: BenXeService) {
  }

  ngOnInit(): void {
    this.getAll();
  }

  onSearch(soXe: string) {
    this.soXe = soXe;
    this.ngOnInit();
  }

  getAll() {
    this.benXeService.getAll(this.soXe).subscribe(benXees => {
      this.benXes = benXees.content;
      debugger
    });
  }

  delete(soXe: string, id: number) {
    this.benXeService.findById(id).subscribe(() => {
      Swal.fire({
        title: 'Are you sure?',
        text: 'You wont be able to revert this!' + name,
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Yes, delete it!'
      }).then((result) => {
        if (result.isConfirmed) {
          this.benXeService.delete(id).subscribe(next => {
            Swal.fire(
              'Deleted!',
              'Your file has been deleted.',
              'success'
            );
            this.ngOnInit();
          }, error => {
            Swal.fire({
              title: 'That bai?',
              text: 'That bai',
              icon: 'error',
            });

          });
        }
      });
    });
  }
}
