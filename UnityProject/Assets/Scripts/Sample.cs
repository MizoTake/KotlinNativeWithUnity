using System.Collections;
using System.Runtime.InteropServices;
using UnityEngine;
using UnityEngine.Networking;
using UnityEngine.Profiling;
using UnityEngine.UI;

public class Sample : MonoBehaviour
{

    [SerializeField] private Text platform;
    [SerializeField] private Text apiResponse;

    private const string url = "https://raw.githubusercontent.com/MizoTake/KotlinNativeWithUnity/master/Response.txt";

#if UNITY_EDITOR
    private const string LibraryName = "KotlinNativeWrapper";
#elif UNITY_IOS
    private const string LibraryName = "__Internal";
#elif UNITY_ANDROID
    private const string LibraryName = "sample.Platform";
#else
    private const string LibraryName = "KotlinNativeWrapper";
#endif

    [DllImport (LibraryName)]
    private static extern string call_platform_name();
    [DllImport (LibraryName)]
    private static extern string call_platform_api(string url);
    
    private AndroidJavaObject pluginClass;
    
    // Start is called before the first frame update
    void Start()
    {
#if UNITY_EDITOR
        platform.text = call_platform_name();
#elif UNITY_ANDROID
        pluginClass = new AndroidJavaObject(LibraryName);
        platform.text = pluginClass.Call<string>("name");
#else
        platform.text = call_platform_name();
#endif

        StartCoroutine(NativeRequest());
        StartCoroutine(UnityRequest());
    }

    IEnumerator NativeRequest()
    {
        Profiler.BeginSample("Call Native Plugin Api");
        var response = "";
#if UNITY_EDITOR
        response = call_platform_api(url);
#elif UNITY_ANDROID        
        response = pluginClass.Call<string>("api", url);
#else
        response = call_platform_api(url);
#endif
        do
        {
            yield return null;
        } while (response != null && response == "");
        Profiler.EndSample();
        apiResponse.text = response;
    }
     

    IEnumerator UnityRequest()
    {
        Profiler.BeginSample("Call UnityRequest");
        using (var request = UnityWebRequest.Get(url))
        {
            yield return request.SendWebRequest();

            if (request.isNetworkError || request.isHttpError)
            {
                Debug.Log(request.error);
            }
            else
            {
//                var response = request.downloadHandler.data;
            }
        }
        Profiler.EndSample();
    }
}
