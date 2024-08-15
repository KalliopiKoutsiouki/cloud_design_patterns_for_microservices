import { Component } from '@angular/core';
import { AxiosService } from '../axios.service';
import { Picture } from '../model/Picture';

@Component({
  selector: 'app-auth-content',
  templateUrl: './auth-content.component.html',
  styleUrls: ['./auth-content.component.css']
})
export class AuthContentComponent {
  data: Picture[] = [];
  userName: string = '';

  constructor(private axiosService: AxiosService) {}

  ngOnInit(): void {
        this.fetchPictures();
  }

  fetchPictures(): void {
    if (!this.userName) {
      console.error('Username is required to fetch pictures');
      return;
    }

    const url = `/user-pictures/${this.userName}`;  

    this.axiosService.request(
      'GET',
      url,
      {}
    ).then(
      (response) => {
        this.data = response.data;
      }).catch(
      (error) => {
        if (error.response.status === 401) {
          this.axiosService.setAuthToken(null);
        } else {
          console.error('Error fetching pictures:', error);
        }
      }
    );
  }
}
