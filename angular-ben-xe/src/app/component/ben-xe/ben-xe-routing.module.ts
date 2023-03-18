import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {BangBenXeComponent} from './bang-ben-xe/bang-ben-xe.component';
import {SuaBenXeComponent} from './sua-ben-xe/sua-ben-xe.component';
import {ThemMoiNhaXeComponent} from './them-moi-nha-xe/them-moi-nha-xe.component';


const routes: Routes = [
  {path: '', component: BangBenXeComponent},
  {path: 'edit/:id', component: SuaBenXeComponent},
  {path: 'create', component: ThemMoiNhaXeComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class BenXeRoutingModule { }
