import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { retry, catchError } from 'rxjs/operators';
import { LocalBook } from './localbook';
import { RemoteBook } from './remotebook';
import { Student } from './student';

@Injectable({
  providedIn: 'root',
})
/**
 * Component will ask Service for the Data and Service will hold the data.
 *Services are Data Containers. i.e. Customer Data/Product Data
 *simple class(fields and methods) will be treated as Services.
 *@ Injectable - a class available to other components
 *When you provide the service at the root level-providedIn: 'root', Angular creates a single, 
  shared instance of service and injects it into any class that asks for it
 */
export class BookdataService {
  constructor(private httpservice: HttpClient) {}
  myData() {
    return 'This is the data from my BookdataService !';
  }
  //local url
  localurl: string = './assets/booklist.json';
  //remote url
  remoteurl: string = 'https://jsonplaceholder.typicode.com/posts';
  //students url
  studenturl: string = 'http://localhost:8080/students/';
  // Get Local books
  GetLocalBooks(): Observable<LocalBook> {
    return this.httpservice
      .get<LocalBook>(this.localurl)
      .pipe(retry(1), catchError(this.myerrorhandler));
  }
  // Get Remote books
  GetRemoteBooks(): Observable<RemoteBook> {
    return this.httpservice
      .get<RemoteBook>(this.remoteurl)
      .pipe(retry(3), catchError(this.myerrorhandler));
  }
  // Get Students
  GetStudents(): Observable<Student> {
    return this.httpservice
      .get<Student>(this.studenturl)
      .pipe(retry(3), catchError(this.myerrorhandler));
  }
  // Error handling
  private myerrorhandler(error: HttpErrorResponse) {
    if (error.status === 0) {
      // A client-side or network error occurred. Handle it accordingly.
      console.error(
        'An error occurred.. either client side or network:',
        error.error
      );
    } else {
      // The backend returned an unsuccessful response code.
      // The response body may contain clues as to what went wrong.
      console.error(
        `Backend returned code ${error.status}, body was: `,
        error.error
      );
    }
    // Return an observable with a user-facing error message.
    return throwError(
      () => new Error('Something bad happened; please try again later.')
    );
  }
}
