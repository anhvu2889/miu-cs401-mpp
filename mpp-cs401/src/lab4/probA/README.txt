@startuml
participant Order
participant OrderLine
participant Product
participant Customer
autonumber
[o-> Order: calculatePrice()
activate Order
loop for each
Order -> OrderLine ++ : calculatePrice()
OrderLine -> Product ++: getPrice(quantity: int)
return: price
return: baseValue
end
Order -> Customer++: getDiscountedValue()
return: discountedValue
return: finalPrice
@enduml