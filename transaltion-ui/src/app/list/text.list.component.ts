import { Component, OnInit } from '@angular/core';
import { TranslationTextText } from '../domain/TranslationTextText';
import { TextService } from '../service/textService';
import { Router } from '@angular/router';


@Component({
  selector: 'app-dashboard',
  templateUrl: './text.list.component.html',
  styleUrls: [ './text.list.component.css' ]
})
export class ListTextComponent implements OnInit {
  //heroes: Hero[] = [];
  textList!: TranslationTextText[];
  textListWithFullText!: TranslationTextText[];
  i!:number;
  len!:number;
  constructor(private textService: TextService,private router: Router) { }

  displayDialog: boolean = false;

  id!:number;
  text!:TranslationTextText;
  visible!:boolean;

  ngOnInit(): void {
    this.visible=false;
    this.textService.getAllText().subscribe(
      (response)=> {
        this.textList= response;
        this.text=this.textList[0];
        this.textList = this.textList.map(item => {
          if (item.text && item.text.length > 150) {
            item.text = item.text.substring(0, 150);
          }
          return item;
        });
       console.log("hi");
     
      },(error)=>{
       
      }

    )
  }

  onRowSelect(event: any) {
    this.visible=true;
    this.id=event;
    this.textService.findById(this.id).subscribe(
      (response)=> {
        this.text= response;
        
       console.log("hi");
     
      },(error)=>{
       
      }

    )
  }

  delete(event: any) {
    this.id=event;
    this.visible=false;

    this.textService.delete(this.id).subscribe(
      (response)=> {
        window.location.reload() ;
        this.router.navigate([this.router.url]);
      
        console.log("hi");
     
      },(error)=>{
       
      }

    )
  }


resizeText(): void {
  
}

  //getHeroes(): void {
  //  this.heroService.getHeroes()
   //   .subscribe(heroes => this.heroes = heroes.slice(1, 5));
  //}
}