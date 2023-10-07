**Details**

I have created Java Spring Boot microservice which contains RestfulAPI for conversions. I have also created dockerfile for ths project.

**Java version:** 11    
**Spring Boot version:** 2.7.11

**API Contract**

GET http://localhost:8080/amphora/v1/convert                                                                                                                        
Params:
1. sourceUnit
2. targetUnit
3. sourceAmount

**What more can be done?**
1. Rate values can be taken to constants.
2. Indirect conversions can be simplified by performing first step conversion and having that rate to make it direct conversion.
3. Use of Exception handling via Advice controller.
4. There maybe other ways like use of Enums to reduce code for conversions.
5. Handling of more edge-cases.