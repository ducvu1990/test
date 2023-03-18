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

  getAll(soXe: string): Observable<BenXe[]> {
    return this.httpClient.get<BenXe[]>('http://localhost:8080/api/ben-xe/search?soXe=' + soXe);
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
