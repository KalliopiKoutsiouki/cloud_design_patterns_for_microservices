import { Component } from '@angular/core';
import { ActuatorService } from './actuator.service';

@Component({
  selector: 'app-actuator',
  template: `
    <button (click)="fetchHealth()">Get Health</button>
    <pre>{{ health | json }}</pre>

    <button (click)="fetchInfo()">Get Info</button>
    <pre>{{ info | json }}</pre>

    <button (click)="fetchMetrics()">Get Metrics</button>
    <pre>{{ metrics | json }}</pre>

    <button (click)="fetchEnv()">Get Env</button>
    <pre>{{ env | json }}</pre>

    <button (click)="fetchLoggers()">Get Loggers</button>
    <pre>{{ loggers | json }}</pre>
  `,
})
export class ActuatorComponent {
  health: any;
  info: any;
  metrics: any;
  env: any;
  loggers: any;

  constructor(private actuatorService: ActuatorService) {}

  fetchHealth() {
    this.actuatorService.getHealth().then(
      (response) => {
        this.health = response.data;
      },
      (error) => {
        console.error('Error fetching health status', error);
      }
    );
  }

  fetchInfo() {
    this.actuatorService.getInfo().then(
      (response) => {
        this.info = response.data;
      },
      (error) => {
        console.error('Error fetching info', error);
      }
    );
  }

  fetchMetrics() {
    this.actuatorService.getMetrics().then(
      (response) => {
        this.metrics = response.data;
      },
      (error) => {
        console.error('Error fetching metrics', error);
      }
    );
  }

  fetchEnv() {
    this.actuatorService.getEnv().then(
      (response) => {
        this.env = response.data;
      },
      (error) => {
        console.error('Error fetching env', error);
      }
    );
  }

  fetchLoggers() {
    this.actuatorService.getLoggers().then(
      (response) => {
        this.loggers = response.data;
      },
      (error) => {
        console.error('Error fetching loggers', error);
      }
    );
  }
}