import { Injectable } from '@angular/core';
import axios from 'axios';

@Injectable({
  providedIn: 'root'
})
export class AxiosService {

  constructor() {
    axios.defaults.baseURL = 'http://localhost:8083';
    axios.defaults.headers.post['Content-Type'] = 'application/json';
  }

  getAuthToken(): string | null {
    return window.localStorage.getItem("auth_token");
  }

  setAuthToken(token: string | null): void {
    if (token !== null) {
      window.localStorage.setItem("auth_token", token);
      axios.defaults.headers.common['Authorization'] = `Bearer ${token}`;
    } else {
      window.localStorage.removeItem("auth_token");
      delete axios.defaults.headers.common['Authorization'];
    }
  }


  request(method: string, url: string, data: any): Promise<any> {
      let headers: any = {};

      if (this.getAuthToken() !== null) {
          headers = {"Authorization": "Bearer " + this.getAuthToken()};
      }

      return axios({
        method: method,
        url: url,
        data: data,
        headers: headers
    }).catch(error => {
      if (error.response && error.response.status === 401) {
        console.error('Unauthorized - Redirect to login or refresh token');
        this.setAuthToken(null);
      }
      return Promise.reject(error);
    });
  }
}
