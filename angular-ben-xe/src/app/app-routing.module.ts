import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HomeComponent} from './shared/home/home.component';


const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'benXe', loadChildren: () => import('./component/ben-xe/ben-xe.module').then(module => module.BenXeModule)}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
