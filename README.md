VolleyManager是对android网络请求框架volley的封装

## 使用说明 ##

```
//使用StringRequest
HashMap<String, String> params = new HashMap<>();
params.put("params1", "xixi");
VolleyManager.sendStringRequest(Request.Method.GET,
        "http://api.wumeijie.net/list", params,
        new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //TODO 处理响应数据
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //TODO 处理请求失败情况
            }
        });
```

或者

```
//使用JsonObjectRequest
JSONObject params = new JSONObject();
try {
    params.put("params1", "xixi");
} catch (JSONException e) {
    e.printStackTrace();
}
VolleyManager.sendJsonObjectRequest(Request.Method.GET,
        "http://api.wumeijie.net/list", params,
        new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                //TODO 处理响应数据
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //TODO 处理请求失败情况
            }
        });
```


volley封装讲解及源码解析: http://blog.csdn.net/y_chengyong/article/details/52766164