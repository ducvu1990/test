import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {BenXe} from '../model/ben-xe';
import {NhaXe} from '../model/nha-xe';
import {DiaDiem} from '../model/dia-diem';
import {LoaiXe} from '../model/loai-xe';

@Injectable({
  providedIn: 'root'
})
export class BenXeService {

  constructor(private httpClient: HttpClient) {
  }

  getAll(soXe: string, pageNumber: number, pageSize: number): Observable<Page<BenXe>> {
    return this.httpClient.get<Page<BenXe>>('http://localhost:8080/api/ben-xe/search?soXe=' + soXe +
      '&pageNumber=' + pageNumber + '&pageSize=' + pageSize);
  }

  getAllDiaDiem(): Observable<DiaDiem[]> {
    return this.httpClient.get<DiaDiem[]>('http://localhost:8080/api/ben-xe/diaDiem');
  }

  getAllLoaiXe(): Observable<LoaiXe[]> {
    return this.httpClient.get<LoaiXe[]>('http://localhost:8080/api/ben-xe/loaiXe');
  }

  getAllNhaXe(): Observable<NhaXe[]> {
    return this.httpClient.get<NhaXe[]>('http://localhost:8080/api/ben-xe/nhaXe');
  }

  delete(id: number): Observable<BenXe> {
    return this.httpClient.delete<BenXe>('http://localhost:8080/api/ben-xe/delete/' + id);
  }

  findById(id: number): Observable<BenXe> {
    return this.httpClient.get<BenXe>('http://localhost:8080/api/ben-xe/' + id);
  }

  update(id: number, benXe: BenXe): Observable<BenXe> {
    return this.httpClient.put<BenXe>('http://localhost:8080/api/ben-xe/update/' + id, benXe);
  }

  create(benXe: BenXe): Observable<BenXe> {
    return this.httpClient.post<BenXe>('http://localhost:8080/api/ben-xe/create', benXe);
  }
}

export interface Page<T> {
  content: T[];
  pageable: {
    sort: {
      sorted: boolean;
      unsorted: boolean;
    };
    pageNumber: number;
    pageSize: number;
    offset: number;
    unpaged: boolean;
  };
  totalPages: number;
  totalElements: number;
  last: boolean;
  size: number;
  number: number;
  sort: {
    sorted: boolean;
    unsorted: boolean;
  };
  numberOfElements: number;
  first: boolean;
  empty: boolean;
}
