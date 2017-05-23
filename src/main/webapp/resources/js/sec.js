var key = CryptoJS.enc.Utf8.parse("123456789abcdefg"); 
var iv  = CryptoJS.enc.Utf8.parse('12389abcdgef4567');
function Encrypt(word){
    srcs = CryptoJS.enc.Utf8.parse(word);
    var encrypted = CryptoJS.AES.encrypt(srcs, key, { iv: iv,mode:CryptoJS.mode.CBC,padding: CryptoJS.pad.Pkcs7});
    return encrypted.ciphertext.toString().toUpperCase();
}

function Decrypt(word){  
    var encryptedHexStr = CryptoJS.enc.Hex.parse(word);
    var srcs = CryptoJS.enc.Base64.stringify(encryptedHexStr);
    var decrypt = CryptoJS.AES.decrypt(srcs, key, { iv: iv,mode:CryptoJS.mode.CBC,padding: CryptoJS.pad.Pkcs7});
    var decryptedStr = decrypt.toString(CryptoJS.enc.Utf8); 
    return decryptedStr.toString();
}