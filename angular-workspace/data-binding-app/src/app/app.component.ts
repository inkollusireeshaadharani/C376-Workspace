import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'data-binding-app';
  imagePath = './assets/bird.jpg';
  buttonStatus = true;
  customerName = 'Tom';
  public myevent(event: any) {
    console.log('I am clicked');
    console.log(event);
  }
}
