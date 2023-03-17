import {Component, OnInit} from '@angular/core';
import {BenXeService} from '../../../service/ben-xe.service';
import {BenXe} from '../../../model/ben-xe';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-bang-ben-xe',
  templateUrl: './bang-ben-xe.component.html',
  styleUrls: ['./bang-ben-xe.component.css']
})
export class BangBenXeComponent implements OnInit {
  benXes: BenXe[];

  constructor(private benXeService: BenXeService) {
  }

  ngOnInit(): void {
    this.getAll();
  }

  getAll() {
    this.benXeService.getAll().subscribe(benXees => {
      this.benXes = benXees;
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
