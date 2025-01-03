# **Microservices-SpringBoot-3.0**

A modern microservices architecture built with **Spring Boot 3.0**, implementing **employee** and **department** services with advanced cloud-native features.

## **Overview**

This project demonstrates a microservices architecture with:

- **Employee Service**
- **Department Service**
- **API Gateway**
- **Config Server**
- **Service Registry**
- **Distributed Tracing**

<img src="architecture.png" alt="Architecture Diagram" width="600" />

## **Architecture Components**

### **Core Services**

- **Department Service**: Manages department-related operations.
- **Employee Service**: Handles employee data and operations.
- **API Gateway**: Routes all requests through a centralized gateway.
- **Config Server**: Centralized configuration management.
- **Service Registry**: Service discovery using **Netflix Eureka**.
- **Zipkin**: Distributed tracing for monitoring and troubleshooting.

## **Technical Stack**

- **Spring Boot 3.0**
- **Spring Cloud**
- **Netflix Eureka**
- **Zipkin**
- **Spring Cloud Gateway**
- **Spring Cloud Config**

## **Project Structure**

```plaintext
├── api-gateway/
├── config-server/
├── department-service/
├── employee-service/
└── service-registry/
