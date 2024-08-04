import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TextService {

  private apiUrl = 'http://localhost:8080/text'; // Replace with your API URL

  constructor(private http: HttpClient) { }

  // Example method to fetch data
  fetchData(): Observable<any> {
    return this.http.get(this.apiUrl);
  }

  // Example method to send data
  sendData(data: any): Observable<any> {
    const url = this.apiUrl+"/create"

    const text = {
        text: data,
      };

    return this.http.post(url, text);
  }

  getAllText():  Observable<any>{
    const url = this.apiUrl+"/all/text";
    return this.http.get(url);
  }

  findById(id:number):  Observable<any>{
    const url = this.apiUrl+"/get/"+id;
    return this.http.get(url);
  }

  delete(id:number):  Observable<any>{
    const url = this.apiUrl+"/delete/"+id;
    return this.http.delete(url);
  }
}