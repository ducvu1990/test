import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { BenXeRoutingModule } from './ben-xe-routing.module';
import { BangBenXeComponent } from './bang-ben-xe/bang-ben-xe.component';
import { SuaBenXeComponent } from './sua-ben-xe/sua-ben-xe.component';
import {ReactiveFormsModule} from '@angular/forms';
import { ThemMoiNhaXeComponent } from './them-moi-nha-xe/them-moi-nha-xe.component';


@NgModule({
  declarations: [BangBenXeComponent, SuaBenXeComponent, ThemMoiNhaXeComponent],
    imports: [
        CommonModule,
        BenXeRoutingModule,
        ReactiveFormsModule
    ]
})
export class BenXeModule { }
