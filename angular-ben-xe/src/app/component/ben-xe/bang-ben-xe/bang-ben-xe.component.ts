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
  page = 0;
  pageSize = 3;
  pageCount = 0;
  pageNumbers: number[] = [];

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
    this.benXeService.getAll(this.soXe, this.page, this.pageSize)
      .subscribe(benXees => {
        this.benXes = benXees.content;
        this.pageCount = benXees.totalPages;
        this.pageNumbers = Array.from({length: this.pageCount}, (v, k) => k + 1);
      });
  }

  previousPage() {
    if (this.page > 0) {
      this.page--;
      this.getAll();
    }
  }

  nextPage() {
    if (this.page < (this.pageCount - 1)) {
      this.page++;
      this.getAll();
    }
  }

  goToPage(pageNumber: number) {
    this.page = pageNumber;
    this.getAll();
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
