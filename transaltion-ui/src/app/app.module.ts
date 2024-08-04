import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms'; // <-- NgModel lives here

import { AppComponent } from './app.component';
import { CommonModule } from '@angular/common';
import { AppRoutingModule } from './app-routing.module';
import { ListTextComponent } from './list/text.list.component';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { InputGroupModule } from 'primeng/inputgroup';
import { InputGroupAddonModule } from 'primeng/inputgroupaddon';
import { MenubarModule } from 'primeng/menubar';
import { PanelMenuModule } from 'primeng/panelmenu';
import { InputTextareaModule } from 'primeng/inputtextarea';
import { ButtonModule } from 'primeng/button';
import { MessagesModule } from 'primeng/messages';
import { TableModule } from 'primeng/table';
import { DialogModule } from 'primeng/dialog';
import { AddTextComponent } from './add_text/text.add.component';





@NgModule({
  declarations: [
    AppComponent,
    AddTextComponent,
    ListTextComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    CommonModule,
    AppRoutingModule, 
    HttpClientModule,
    BrowserAnimationsModule,
    InputGroupModule,
    InputGroupAddonModule,
    MenubarModule,
    PanelMenuModule,
    InputTextareaModule,
    ButtonModule,
    HttpClientModule,
    MessagesModule,
    TableModule,
    DialogModule
    
    
    


  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }