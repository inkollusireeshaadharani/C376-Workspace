import { Component, OnInit, Input, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-child',
  templateUrl: './child.component.html',
  styleUrls: ['./child.component.css'],
})
export class ChildComponent {
  title = 'childapp';
  name = 'Dharani';
  @Input('parentData') public mycompname: any;

  @Output()
  public childEvent = new EventEmitter();

  fireEvent() {
    this.childEvent.emit(
      'Hello to Parent company Wiley from its child WileyEdge'
    );
  }
}
