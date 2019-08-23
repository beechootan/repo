

import { Employee } from './employee';

export interface appointmentStatus {

    id: number
    queueNum: boolean
    employeeId: boolean
    checkInTime: Date
    checkOutTime: Date
    symptom: String
    status: boolean
    isToday: boolean
    lastUpdBy: number
    employee: Employee

}


export class postData {
    
    lastUpdBy: number
    employeeId: number
}

export class checkInData {
    appointmentId: number
    nurseID: number
}