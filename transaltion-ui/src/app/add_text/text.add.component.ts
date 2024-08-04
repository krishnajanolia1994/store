import { Component, OnInit } from "@angular/core";
//import { Hero } from "../hero";
import { TextService } from "../service/textService";
import { Message } from 'primeng/api';


@Component({
  selector: 'app-heroes',
  templateUrl: './text.add.component.html',
  styleUrls: ['./text.add.component.css']
})
export class AddTextComponent implements OnInit {
  messages: Message[] =[];

  ngOnInit(): void {
    
  }

  constructor(private textService: TextService) {}

  
  text!: string;


  saveText(){
    console.log(this.text);
    this.textService.sendData(this.text).subscribe(
      (response)=> {
        this.text="";
        this.messages = [
          { severity: 'success', detail: 'Success Message' },
      ];
      },(error)=>{
        console.log(error);
        this.messages = [
          { severity: 'error', detail: 'Error Message' },
      ];
      }

    )
  }

  
  

  
}