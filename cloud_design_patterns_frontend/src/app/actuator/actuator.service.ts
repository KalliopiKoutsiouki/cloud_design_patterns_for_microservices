import { Injectable } from '@angular/core';
import { AxiosService } from '../axios.service';

@Injectable({
  providedIn: 'root',
})
export class ActuatorService {
  private baseUrl = 'http://localhost:8083/actuator'; // Replace with your Spring Boot app's URL

  constructor(private axiosService: AxiosService) {}

  getHealth() {
    return this.axiosService.request('GET', `${this.baseUrl}/health`, {});
  }

  getInfo() {
    return this.axiosService.request('GET', `${this.baseUrl}/info`, {});
  }

  getMetrics() {
    return this.axiosService.request('GET', `${this.baseUrl}/metrics`, {});
  }

  getEnv() {
    return this.axiosService.request('GET', `${this.baseUrl}/env`, {});
  }

  getLoggers() {
    return this.axiosService.request('GET', `${this.baseUrl}/loggers`, {});
  }
}