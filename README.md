# druid

## encode 

`java -cp druid-1.1.19.jar com.alibaba.druid.filter.config.ConfigTools 密码`

Example:

`java -cp druid-1.1.19.jar com.alibaba.druid.filter.config.ConfigTools jas502n`

```
privateKey:MIIBUwIBADANBgkqhkiG9w0BAQEFAASCAT0wggE5AgEAAkEAsHAWqFM3aIiKrc8sz2bR3+DpA9RdoOMZZKKdP9MRVKbTRXZPzJiNxHu0Lz//J1Q1iNS1x4NPhC/W7FCGGMk7NQIDAQABAkA3wVQHoTRzPiLExiFc8RsFamd4JFXqD5noqVKT5rklTINKAdJarQL2h/Bfh/kB4b2K8eNnTLLRNpSQ4qrxQboBAiEA8APQtsGkXDjJ9pYcJZkzzIsCiz3TFhUiMs+lOFFsrsECIQC8ME2B8ipKX2F0uSa2AZhxvBdcF2ueTVblaQvFyDGddQIgE5yMMlKyRmLRhdeQJzZUeDMnmw8LL3O8nqA+5NIqakECIGgC0nPl4pXkjbqzsr+ZtiX2bXrKvwJpgIOfQZB5C2MZAiB9MVIKNQKRgiTyvk1KZ4quUzV92dxmWQ17iDLWiwxysA==

publicKey:MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBALBwFqhTN2iIiq3PLM9m0d/g6QPUXaDjGWSinT/TEVSm00V2T8yYjcR7tC8//ydUNYjUtceDT4Qv1uxQhhjJOzUCAwEAAQ==

password:k5g4589VT3WmsgKimh8XHTtuShBwA3MANRzbIddL/u/mnAyLEfuFqKgzkaRhO/1WSQrc99qJJhmwcB4cGX06Kw==

```

## decode

`com.alibaba.druid.filter.config.ConfigTools#decrypt`

```
    public static String decrypt(PublicKey publicKey, String cipherText) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");

        try {
            cipher.init(2, publicKey);
        } catch (InvalidKeyException var7) {
            RSAPublicKey rsaPublicKey = (RSAPublicKey)publicKey;
            RSAPrivateKeySpec spec = new RSAPrivateKeySpec(rsaPublicKey.getModulus(), rsaPublicKey.getPublicExponent());
            Key fakePrivateKey = KeyFactory.getInstance("RSA").generatePrivate(spec);
            cipher = Cipher.getInstance("RSA");
            cipher.init(2, fakePrivateKey);
        }

        if (cipherText != null && cipherText.length() != 0) {
            byte[] cipherBytes = Base64.base64ToByteArray(cipherText);
            byte[] plainBytes = cipher.doFinal(cipherBytes);
            return new String(plainBytes);
        } else {
            return cipherText;
        }
    }
```


`ConfigTools.decrypt(publicKey, password)`

`java -jar bruid_decode.jar`

```
Set publicKey: MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBALBwFqhTN2iIiq3PLM9m0d/g6QPUXaDjGWSinT/TEVSm00V2T8yYjcR7tC8//ydUNYjUtceDT4Qv1uxQhhjJOzUCAwEAAQ==
Set password: k5g4589VT3WmsgKimh8XHTtuShBwA3MANRzbIddL/u/mnAyLEfuFqKgzkaRhO/1WSQrc99qJJhmwcB4cGX06Kw==
解密明文密码: jas502n
```
