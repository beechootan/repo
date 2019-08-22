

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
    employeeId: number
    patientId: number
}