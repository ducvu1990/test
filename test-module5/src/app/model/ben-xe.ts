import {DiaDiem} from './dia-diem';
import {LoaiXe} from './loai-xe';
import {NhaXe} from './nha-xe';

export interface BenXe {
  id: number;
  soXe: string;
  loaiXe: LoaiXe;
  nhaXe: NhaXe;
  diemDi: DiaDiem;
  diemDen: DiaDiem;
  soDienThoai: string;
  email: string;
  gioDi: string;
  gioDen: string;
}
