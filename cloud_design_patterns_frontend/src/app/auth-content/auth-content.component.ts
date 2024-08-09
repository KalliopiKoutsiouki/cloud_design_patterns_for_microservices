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
  userId: string = '';

  constructor(private axiosService: AxiosService) {}

  ngOnInit(): void {
        this.fetchPictures();
  }

  fetchPictures(): void {
    if (!this.userId) {
      console.error('User ID is required to fetch pictures');
      return;
    }

    const url = `/user-pictures/${this.userId}`;  // Construct URL dynamically based on userId

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
