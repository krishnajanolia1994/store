import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { ListTextComponent } from './list/text.list.component';
import { DialogModule } from 'primeng/dialog';
import { AddTextComponent } from './add_text/text.add.component';


const routes: Routes = [
  { path: 'add/text', component: AddTextComponent },
  { path: 'list/text', component: ListTextComponent },
  { path: '', redirectTo: '/list/text', pathMatch: 'full' }
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
