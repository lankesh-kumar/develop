# Read me!
Please run test cases using file com.lankesh.test.controller.PasswordCheckIntegrationTest in eclipse with option Run as Junit test

## Junit Test results output
MockHttpServletRequest:
      HTTP Method = GET
      Request URI = /check-password-strength
#       Parameters = {password=[test1123]}
          Headers = [Content-Type:"application/json;charset=UTF-8"]
             Body = null
    Session Attrs = {}
MockHttpServletResponse:
           Status = 200
    Error message = null
          Headers = [Content-Type:"text/plain;charset=UTF-8", Content-Length:"30"]
     Content type = text/plain;charset=UTF-8
#             Body = {"status":"password is valid"}
    Forwarded URL = null
   Redirected URL = null
          Cookies = []

MockHttpServletRequest:
      HTTP Method = GET
      Request URI = /check-password-strength
#       Parameters = {password=[validpasw12]}
          Headers = [Content-Type:"application/json;charset=UTF-8"]
             Body = null
    Session Attrs = {}
MockHttpServletResponse:
           Status = 200
    Error message = null
          Headers = [Content-Type:"text/plain;charset=UTF-8", Content-Length:"30"]
     Content type = text/plain;charset=UTF-8
#             Body = {"status":"password is valid"}
    Forwarded URL = null
   Redirected URL = null
          Cookies = []
          
          

MockHttpServletRequest:
      HTTP Method = GET
      Request URI = /check-password-strength
#       Parameters = {password=[aaa234]}
          Headers = [Content-Type:"application/json;charset=UTF-8"]
             Body = null
    Session Attrs = {}
MockHttpServletResponse:
           Status = 400
    Error message = null
          Headers = [Content-Type:"application/json;charset=UTF-8"]
     Content type = application/json;charset=UTF-8
#             Body = [{"code":"VALIDATION-ERROR","message":"Same character' aa' is repeating","severity":"ERROR"}]
    Forwarded URL = null
   Redirected URL = null
          Cookies = []
          
          

MockHttpServletRequest:
      HTTP Method = GET
      Request URI = /check-password-strength
#       Parameters = {password=[]}
          Headers = [Content-Type:"application/json;charset=UTF-8"]
             Body = null
    Session Attrs = {}
MockHttpServletResponse:
           Status = 400
    Error message = null
          Headers = [Content-Type:"application/json;charset=UTF-8"]
     Content type = application/json;charset=UTF-8
#             Body = [{"code":"VALIDATION-ERROR","message":"Only small case alpha and numeric values are allowed","severity":"ERROR"},{"code":"VALIDATION-ERROR","message":"Password length must be min 5 and max 12","severity":"ERROR"}]
    Forwarded URL = null
   Redirected URL = null
          Cookies = []



MockHttpServletRequest:
      HTTP Method = GET
      Request URI = /check-password-strength
#       Parameters = {password=[I am greater than 12 length]}
          Headers = [Content-Type:"application/json;charset=UTF-8"]
             Body = null
    Session Attrs = {}
MockHttpServletResponse:
           Status = 400
    Error message = null
          Headers = [Content-Type:"application/json;charset=UTF-8"]
     Content type = application/json;charset=UTF-8
#             Body = [{"code":"VALIDATION-ERROR","message":"Same character' th' is repeating","severity":"ERROR"},{"code":"VALIDATION-ERROR","message":"Password length must be min 5 and max 12","severity":"ERROR"},{"code":"VALIDATION-ERROR","message":"Only small case alpha and numeric values are allowed","severity":"ERROR"}]
    Forwarded URL = null
   Redirected URL = null
          Cookies = []



MockHttpServletRequest:
      HTTP Method = GET
      Request URI = /check-password-strength
#       Parameters = {password=[vaLidpasw12]}
          Headers = [Content-Type:"application/json;charset=UTF-8"]
             Body = null
    Session Attrs = {}
MockHttpServletResponse:
           Status = 400
    Error message = null
          Headers = [Content-Type:"application/json;charset=UTF-8"]
     Content type = application/json;charset=UTF-8
 #            Body = [{"code":"VALIDATION-ERROR","message":"Only small case alpha and numeric values are allowed","severity":"ERROR"}]
    Forwarded URL = null
   Redirected URL = null
          Cookies = []



MockHttpServletRequest:
      HTTP Method = GET
      Request URI = /check-password-strength
#       Parameters = {password=[test]}
          Headers = [Content-Type:"application/json;charset=UTF-8"]
             Body = null
    Session Attrs = {}
MockHttpServletResponse:
           Status = 400
    Error message = null
          Headers = [Content-Type:"application/json;charset=UTF-8"]
     Content type = application/json;charset=UTF-8
#             Body = [{"code":"VALIDATION-ERROR","message":"Only small case alpha and numeric values are allowed","severity":"ERROR"},{"code":"VALIDATION-ERROR","message":"Password length must be min 5 and max 12","severity":"ERROR"}]
    Forwarded URL = null
   Redirected URL = null
          Cookies = []



MockHttpServletRequest:
      HTTP Method = GET
      Request URI = /check-password-strength
 #      Parameters = {password=[ttpeeatte1]}
          Headers = [Content-Type:"application/json;charset=UTF-8"]
             Body = null
    Session Attrs = {}
MockHttpServletResponse:
           Status = 400
    Error message = null
          Headers = [Content-Type:"application/json;charset=UTF-8"]
     Content type = application/json;charset=UTF-8
#             Body = [{"code":"VALIDATION-ERROR","message":"Same character' tt' is repeating","severity":"ERROR"}]
    Forwarded URL = null
   Redirected URL = null
          Cookies = []



MockHttpServletRequest:
      HTTP Method = GET
      Request URI = /check-password-strength
#       Parameters = {password=[repeeatte1]}
          Headers = [Content-Type:"application/json;charset=UTF-8"]
             Body = null
    Session Attrs = {}
MockHttpServletResponse:
           Status = 200
    Error message = null
          Headers = [Content-Type:"text/plain;charset=UTF-8", Content-Length:"30"]
     Content type = text/plain;charset=UTF-8
 #            Body = {"status":"password is valid"}
    Forwarded URL = null
   Redirected URL = null
          Cookies = []
          
[INFO] Tests run: 9, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 3.231 s - in com.lankesh.test.controller.PasswordCheckIntegrationTest
