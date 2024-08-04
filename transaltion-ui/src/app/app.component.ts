import { Component } from '@angular/core';
import { MenuItem } from 'primeng/api';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  title = 'WelCome To H&M';

  items: MenuItem[] | undefined;

  ngOnInit() {
    this.items = [
        {
            label: 'New',
            icon: 'pi pi-home',
            routerLink: 'add/text'
        },
        {
            label: 'List',
            icon: 'pi pi-star',
            routerLink: 'list/text'
        },
       
    ];
}



}
