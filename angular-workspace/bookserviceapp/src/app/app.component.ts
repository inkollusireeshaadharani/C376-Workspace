import { Component } from '@angular/core';
import { BookdataService } from './bookdata.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  /* constructor is called when component is created
     constructor can be used for DI - Dependency Injection */
  constructor(private bookservice: BookdataService) {}
  title = 'bookserviceapp';
  somedata: string = '';
  localbookList: any[] | undefined;
  remotebookList: any[] | undefined;
  studentList: any[] | undefined;
  // Load localbooks
  loadlocalbooks() {
    return this.bookservice.GetLocalBooks().subscribe((data: any) => {
      this.localbookList = data;
    });
  }
  // Load remotebooks
  loadremotebooks() {
    return this.bookservice.GetRemoteBooks().subscribe((data: any) => {
      this.remotebookList = data;
    });
  }
  // Load students
  loadstudents() {
    return this.bookservice.GetStudents().subscribe((data: any) => {
      this.studentList = data;
    });
  }
  /*
    ngOnInit() is a lifecycle hook, which runs when the component loads
    */
  ngOnInit() {
    this.somedata = this.bookservice.myData();
    this.loadlocalbooks();
    this.loadremotebooks();
    this.loadstudents();
  }
}
