@Perfecto
  Feature: Multiple Devices
    @twoDevicesSMS
  Scenario: Send SMS
      And I Launch application on Device "perfectodeviiRemote"
      When I Launch application on Device "perfectoRemote"
      Then I send SMS from "perfectoRemote" to "perfectodeviiRemote"

