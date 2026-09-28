import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { FormsModule } from '@angular/forms'; // Necessário para ngModel / task
import { CommonModule } from '@angular/common';
import { TaskList } from './task-list/task-list';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [FormsModule, CommonModule, TaskList],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class AppComponent {
  tasks: string[] = [];
  task = '';

  add(): void {
    if (this.task.trim()) {
      this.tasks.push(this.task);
      this.task = '';
    }
  }
}