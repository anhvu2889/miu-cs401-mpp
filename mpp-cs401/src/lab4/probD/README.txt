@startuml
[o-> Employee++: calcCompensation(month, year)
Employee -> Hourly++ : calcGrossPay(month, year)
return grossPay
Employee -> Salaried++: calcGrossPay(month, year)
return grossPay
Employee -> Commissioned++ : calcGrossPay(month, year)
loop for each Order
Commissioned -> Order++: getOrderDate()
return orderDate
Commissioned -> Order++: getOrderAmount()
return orderAmount
end
return grossPay
return PayCheck
@enduml