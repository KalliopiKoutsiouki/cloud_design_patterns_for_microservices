import { Component } from '@angular/core';
import { AxiosService } from '../axios.service';

@Component({
  selector: 'app-content',
  templateUrl: './content.component.html',
  styleUrls: ['./content.component.css']
})
export class ContentComponent {
	componentToShow: string = "login";
	isLoggedIn: boolean = false;

	constructor(private axiosService: AxiosService) { }

	showComponent(componentToShow: string): void {
    this.componentToShow = componentToShow;
	if (componentToShow === 'login') {
		this.isLoggedIn = false;
	  }
  }

	onLogin(input: any): void {
		this.axiosService.request(
		    "POST",
		    "/login",
		    {
		        username: input.username,
		        password: input.password
		    }).then(
		    response => {
		        this.axiosService.setAuthToken(response.data.token);
				this.isLoggedIn = true; 
		        this.componentToShow = "pictures";
		    }).catch(
		    error => {
		        this.axiosService.setAuthToken(null);
				this.isLoggedIn = false; 
		        this.componentToShow = "welcome";
		    }
		);

	}

	onRegister(input: any): void {
		this.axiosService.request(
		    "POST",
		    "/register",
		    {
		        firstName: input.firstName,
		        lastName: input.lastName,
		        username: input.username,
		        password: input.password
		    }).then(
		    response => {
		        this.axiosService.setAuthToken(response.data.token);
				this.isLoggedIn = true;
		        this.componentToShow = "pictures";
		    }).catch(
		    error => {
		        this.axiosService.setAuthToken(null);
				this.isLoggedIn = false;
		        this.componentToShow = "welcome";
		    }
		);
	}

}
