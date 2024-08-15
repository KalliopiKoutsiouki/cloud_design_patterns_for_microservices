import { Component, EventEmitter, Output, Input } from '@angular/core';

@Component({
  selector: 'app-buttons',
  templateUrl: './buttons.component.html',
  styleUrls: ['./buttons.component.css']
})
export class ButtonsComponent {
  @Input() isLoggedIn: boolean = false;
	@Output() loginEvent = new EventEmitter();
	@Output() logoutEvent = new EventEmitter();

  handleLogout(): void {
    this.logoutEvent.emit(); 
    this.isLoggedIn = false; 
  
  }
}
