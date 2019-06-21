Please run test cases using file com.lankesh.test.controller.PasswordCheckIntegrationTest in eclipse with option Run as Junit test

Test results are as follows

--- test case when_passed_valid_then_sucess_response ---
MockHttpServletRequest:
      HTTP Method = POST
      Request URI = /check-password-strength
       Parameters = {input=[validpasw12]}
          Headers = [Content-Type:"application/json;charset=UTF-8"]
             Body = null
    Session Attrs = {}

MockHttpServletResponse:
           Status = 200
    Error message = null
          Headers = [Content-Type:"application/json;charset=UTF-8"]
     Content type = application/json;charset=UTF-8
             Body = [{"code":"SUCCESS","description":"Input meets required conditions for password"}]
    Forwarded URL = null
   Redirected URL = null
          Cookies = []


--- test case when_passed_null_or_empty_then_error_response ---
MockHttpServletRequest:
      HTTP Method = POST
      Request URI = /check-password-strength
       Parameters = {input=[]}
          Headers = [Content-Type:"application/json;charset=UTF-8"]
             Body = null
    Session Attrs = {}

MockHttpServletResponse:
           Status = 400
    Error message = null
          Headers = [Content-Type:"application/json;charset=UTF-8"]
     Content type = application/json;charset=UTF-8
             Body = [{"code":"ERR-EMPTY","description":"Input is empty"}]
    Forwarded URL = null
   Redirected URL = null
          Cookies = []


--- test case when_passed_greater_than_max_length__then_error_response ---
MockHttpServletRequest:
      HTTP Method = POST
      Request URI = /check-password-strength
       Parameters = {input=[I am greater than 12 length]}
          Headers = [Content-Type:"application/json;charset=UTF-8"]
             Body = null
    Session Attrs = {}

MockHttpServletResponse:
           Status = 400
    Error message = null
          Headers = [Content-Type:"application/json;charset=UTF-8"]
     Content type = application/json;charset=UTF-8
             Body = [{"code":"ERR-MAX-LEN","description":"Maximum of 12 Characters are allowed"}]
    Forwarded URL = null
   Redirected URL = null
          Cookies = []

--- test case when_passed_invalid_then_error_response ---
MockHttpServletRequest:
      HTTP Method = POST
      Request URI = /check-password-strength
       Parameters = {input=[vaLidpasw12]}
          Headers = [Content-Type:"application/json;charset=UTF-8"]
             Body = null
    Session Attrs = {}

MockHttpServletResponse:
           Status = 400
    Error message = null
          Headers = [Content-Type:"application/json;charset=UTF-8"]
     Content type = application/json;charset=UTF-8
             Body = [{"code":"ERR-ALPHA-NUM-ONLY","description":"Only small case alpha and numeric values are allowed"}]
    Forwarded URL = null
   Redirected URL = null
          Cookies = []

--- test case when_passed_less_than_min_length__then_error_response ---
MockHttpServletRequest:
      HTTP Method = POST
      Request URI = /check-password-strength
       Parameters = {input=[test]}
          Headers = [Content-Type:"application/json;charset=UTF-8"]
             Body = null
    Session Attrs = {}

MockHttpServletResponse:
           Status = 400
    Error message = null
          Headers = [Content-Type:"application/json;charset=UTF-8"]
     Content type = application/json;charset=UTF-8
             Body = [{"code":"ERR-MIN-LEN","description":"Minium of 5 Characters are required"}]
    Forwarded URL = null
   Redirected URL = null
          Cookies = []

--- test case when_passed_repeating_character_then_error_response ---
MockHttpServletRequest:
      HTTP Method = POST
      Request URI = /check-password-strength
       Parameters = {input=[repeeate17]}
          Headers = [Content-Type:"application/json;charset=UTF-8"]
             Body = null
    Session Attrs = {}

MockHttpServletResponse:
           Status = 400
    Error message = null
          Headers = [Content-Type:"application/json;charset=UTF-8"]
     Content type = application/json;charset=UTF-8
             Body = [{"code":"ERR-REPEAT","description":"Same character' e' is repeating more than once"}]
    Forwarded URL = null
   Redirected URL = null
          Cookies = []
