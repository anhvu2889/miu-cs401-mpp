@startuml
participant CheckoutForm
participant CheckoutController
participant CheckoutRecord
participant LibraryMember
participant LibraryDBSubsystem
[o-> CheckoutForm++: checkoutBook()
CheckoutForm -> CheckoutController++: checkoutBook(book, member)
CheckoutController -> LibraryMember++: getCheckoutPeriod()
return period
CheckoutController -> CheckoutRecord++: setDueDate(period)
deactivate CheckoutRecord
CheckoutController -> CheckoutRecord++: addBook(book)
deactivate CheckoutRecord
CheckoutController -> LibraryMember++: addCheckoutRecord(checkoutRecord)
deactivate LibraryMember
CheckoutController -> LibraryMember++: getMemberId()
return memberId
CheckoutController -> LibraryDBSubsystem++: addCheckoutRecord(memberId, checkoutRecord)
deactivate CheckoutController
deactivate LibraryDBSubsystem
CheckoutForm -> CheckoutForm: displayCheckoutInfo()
CheckoutForm -> CheckoutForm: clearCheckoutFields()
deactivate CheckoutForm
@enduml